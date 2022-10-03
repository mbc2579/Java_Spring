package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;

import java.util.Objects;

public class facade_Main {
    public static void main(String[] args) {
        Ftp ftpClient = new Ftp("www.foo.co.kr", 22, "/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();

        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();

        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

        SftpClient sftpClient = new SftpClient("www.foo.co.kr", 22, "/home/etc", "text.tmp");
        sftpClient.connect();

        sftpClient.writer();

        sftpClient.read();

        sftpClient.disConnect();
    }
}
