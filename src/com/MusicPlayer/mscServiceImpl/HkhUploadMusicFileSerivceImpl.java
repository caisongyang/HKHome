package MusicPlayer.mscServiceImpl;

import MusicPlayer.mscDao.HkhuploadMscFileDao;
import MusicPlayer.mscService.HkhUploadMusicFileSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class HkhUploadMusicFileSerivceImpl implements HkhUploadMusicFileSerivce {
    @Autowired
    private HkhuploadMscFileDao upfileDao;


    @Override
    public String uploadMusicFile(List<Map<String, Object>> map) {
        String message = "";
        try{
            upfileDao.addMusicFile(map);
            message = "上传成功";
       }catch (Exception e){
            e.printStackTrace();
            message = "上传报错";
       }
        return message;
    }
}
