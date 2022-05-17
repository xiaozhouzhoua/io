package com.aio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.CompletionHandler;
import java.nio.charset.Charset;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class AsynchronousFileChannelDemo implements CompletionHandler<Integer, BlockingQueue<Boolean>> {

    private static final int BUFFER_SIZE = 8 * 1024;
    private static final String FILE_NAME = "文本.txt";

    private ByteBuffer byteBuffer;
    private AsynchronousFileChannel asyncChannel;
    private long position = 0;

    void readLargeTextFile() throws IOException, InterruptedException {
        byteBuffer = ByteBuffer.allocate(BUFFER_SIZE);

        BlockingQueue<Boolean> done = new ArrayBlockingQueue<>(1);

        Path path = Paths.get(FILE_NAME);

        asyncChannel = asyncChannel.open(path, StandardOpenOption.READ);

        asyncChannel.read(byteBuffer, position, done, this);

        // 阻塞直到文件已经读完
        var result = done.take();
        if (result) {
            System.out.println("文件读取完毕！！！");
        }

    }

    @Override
    public void completed(Integer numread, BlockingQueue<Boolean> done) {
        if (numread < 0) {
            try {
                done.put(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return;
        }

        position += numread;
        byteBuffer.flip();
        System.out.println(Charset.defaultCharset().decode(byteBuffer));
        byteBuffer.clear();
        // 继续读文件
        asyncChannel.read(byteBuffer, position, done, this);
    }

    @Override
    public void failed(Throwable exc, BlockingQueue<Boolean> done) {
        try {
            done.put(false);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException, InterruptedException {
        new AsynchronousFileChannelDemo().readLargeTextFile();
    }
}