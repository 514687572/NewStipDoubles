package com.stip.net.storage.utils;

import com.stip.net.storage.ImageAttribute;
import com.stip.net.storage.ImageFormat;

import javax.imageio.ImageWriter;
import javax.imageio.stream.FileImageOutputStream;
import javax.imageio.stream.ImageOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.AsynchronousFileChannel;
import java.nio.channels.AsynchronousSocketChannel;
import java.nio.channels.CompletionHandler;
import java.nio.file.*;
import java.util.concurrent.*;
import java.nio.file.StandardOpenOption;

import static java.nio.file.StandardOpenOption.*;

/**
 * @author wangzun
 * @version 2019/4/23 下午5:44
 * @desc
 */
public class StipImageHelper {


    public void write(ImageAttribute imageAttribute, ImageFormat imageFormat) {
        String fullFileDri = imageAttribute.getPath() + "/" + imageAttribute.getFileName() + "." + ImageFormat.getDesc(imageFormat).toLowerCase();
        Path path = Paths.get(fullFileDri);

        try {
            if (Files.notExists(path)) {
                Files.createFile(path);
            }
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, WRITE,CREATE);
            ByteBuffer buffer = ByteBuffer.wrap(imageAttribute.getImgBytes());
            fileChannel.write(
                    buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            //if files write completed then write bin_log for backup
                            System.out.println("写完了？？？");
                            attachment.flip().clear();

                        }
                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            //if files write failed then write err_log for retry
                            System.out.println("faild");

                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void executorActions(Runnable runnable) {
        runnable.run();
    }

    public static void main(String[] args) throws InterruptedException {
        StipImageHelper helper = new StipImageHelper();

        ImageAttribute attribute = new ImageAttribute();
        attribute.setPath("/Users/Yang/github-wz");
        attribute.setFileName("test");
        helper.read(attribute,ImageFormat.PNG);

        while (true) {
            Thread.sleep(1000);
            System.out.println("");
        }

    }

    public void read(ImageAttribute imageAttribute, ImageFormat imageFormat) {
        String fullFileDri = imageAttribute.getPath() + "/" + imageAttribute.getFileName() + "." + ImageFormat.getDesc(imageFormat).toLowerCase();
        Path path = Paths.get(fullFileDri);

        try {
            AsynchronousFileChannel fileChannel = AsynchronousFileChannel.open(path, READ);
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(
                    buffer, 0, buffer, new CompletionHandler<Integer, ByteBuffer>() {
                        @Override
                        public void completed(Integer result, ByteBuffer attachment) {
                            //if files write completed then write bin_log for backup
                            System.out.println(result);
                            attachment.flip();
                            ImageAttribute attribute = new ImageAttribute();
                            attribute.setPath("/Users/Yang/github-wz");
                            attribute.setFileName("imgTest");
                            byte[] data = new byte[attachment.limit()];
                            attachment.get(data);
                            attribute.setImgBytes(data);
                            attachment.clear();
                            write(attribute,ImageFormat.PNG);
                        }
                        @Override
                        public void failed(Throwable exc, ByteBuffer attachment) {
                            //if files write failed then write err_log for retry
                            System.out.println("失败了");

                        }
                    });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
