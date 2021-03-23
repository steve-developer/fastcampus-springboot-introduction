package com.company.design.facade;

public class SftpClient {

    private FtpProtocol ftpProtocol;
    private FileReader fileReader;
    private FileWriter fileWriter;

    public SftpClient(String host, int port, String path, String fileName){
        this.ftpProtocol = new FtpProtocol(host, port, path);
        this.fileReader = new FileReader(fileName);
        this.fileWriter = new FileWriter(fileName);
    }

    public void connect(){
        this.ftpProtocol.connect();
        this.ftpProtocol.moveDirectory();
        this.fileReader.fileConnect();
        this.fileWriter.fileConnect();

    }

    public void write(String content){
        this.fileWriter.fileWrite(content);
    }

    public String read(){
        return this.fileReader.fileRead();
    }

    public void disConnect(){
        this.fileReader.fileDisconnect();
        this.fileWriter.fileDisconnect();
        this.ftpProtocol.disConnect();
    }

}
