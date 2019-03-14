package MusicPlayer.mscServiceImpl;

import MusicPlayer.mscDao.HkhuploadMscFileDao;
import MusicPlayer.mscService.HkhUploadMusicFileSerivce;
import com.mysql.cj.jdbc.Blob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
@Service
public class HkhUploadMusicFileSerivceImpl implements HkhUploadMusicFileSerivce {
    @Autowired
    private HkhuploadMscFileDao upfileDao;


    @Override
    public String uploadMusicFile(Map<String, Object> map) {
        String message = "";
        System.out.println(map);
        MultipartFile mscfile =  (MultipartFile) map.get("mp3file");
        /*  File mfile = new File("");
        byte [] datas = new byte[0];//获取文件中的数据*/
        try {
            //拼接路径
            String path = "D:\\WORK\\UPLOAD-MUSIC\\"+mscfile.getOriginalFilename();
            // 把文件上传至path的路径
            File localFile = new File(path);
            mscfile.transferTo(localFile);
            //datas = mscfile.getBytes();
            //Blob blob = new Blob(datas);//创建Blob对象
            map.put("mp3file",path);
            upfileDao.addMusicFile(map);
            message = "上传成功";
       }catch (IOException e) {
            e.printStackTrace();
       }catch (Exception e){
            e.printStackTrace();
            message = "上传报错";
       }
        return message;
    }

}
