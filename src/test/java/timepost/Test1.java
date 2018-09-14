package timepost;

import java.io.IOException;


import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import java.util.UUID;

import org.apache.commons.io.IOUtils;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.FileInfo;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.StorageClient1;
import org.csource.fastdfs.StorageServer;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;

/**
 * Created by sgt on 2018/9/10 0010.
 */
public class Test1 {
//    connect_timeout =2
//
//    network_timeout = 40
//
//    charset = UTF-8
//
//    http.tracker_http_port = 80
//
//    http.anti_steal_token = no
//
//    http.secret_key = FastDFS1234567890
//
//    tracker_server = 10.2.1.17:22122

    public static String conf_filename = "E:\\fdfs_client.conf";
    public static void main(String[] args) {
        // group2/M00/22/88/CgIBE1uV1WmASF8BAAKY1yK8cTU875.jpg
        //group1/M00/30/0A/CgIBEluV0z2AKZWCAAIVxakhWW0433.jpg
        //group2/M00/22/88/CgIBE1uV1WmASF8BAAKY1yK8cTU875.jpg
//        downloadimgp('1408337853378_000.jpg','http://10.2.1.17:8000/group1/M00/2E/7A/CgIBEltrrCWAfDsWAAVMIS58kho959.jpg')
//        downloadimgp('ERP系统启动 - 副本.png','http://10.2.1.17:8000/group3/M00/0A/B3/CgIBSVta94WAa0bZAAK-nAIwfU8347.png')
//        downloadimgp('ERP系统启动 - 副本.png','http://10.2.1.17:8000/group1/M00/2D/3F/CgIBEltaiASAFBfPAAK-nAIwfU8891.png')
//        downloadimgp('1.jpg','http://10.2.1.17:8000/group1/M00/2C/01/CgIBEltGuxmAP5-UAAEbtLNuYkQ796.jpg')
//        downloadimgp('316197.jpg','http://10.2.1.17:8000/group3/M00/09/DF/CgIBSVtGG8CAOhK7AAH9_w1kkBg092.jpg')
//        downloadimgp('316197.jpg','http://10.2.1.17:8000/group3/M00/09/DF/CgIBSVtGG8CAOhK7AAH9_w1kkBg092.jpg')
//        downloadimgp('316197.jpg','http://10.2.1.17:8000/group3/M00/09/DF/CgIBSVtGG8CAOhK7AAH9_w1kkBg092.jpg')
        try {

            ClientGlobal.init(conf_filename);

            TrackerClient tracker = new TrackerClient();
            TrackerServer trackerServer = tracker.getConnection();
//            StorageServer storageServer = null;
            StorageServer storageServer = null;

            StorageClient storageClient = new StorageClient(trackerServer, storageServer);
            byte[] b = storageClient.download_file("group3", "M00/09/DF/CgIBSVtGG8CAOhK7AAH9_w1kkBg092.jpg");
            System.out.println(b);
            IOUtils.write(b, new FileOutputStream("D:/"+UUID.randomUUID().toString()+".jpeg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
