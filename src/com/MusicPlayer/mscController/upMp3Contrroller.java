package MusicPlayer.mscController;

import MusicPlayer.mscService.HkhUploadMusicFileSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class upMp3Contrroller {

    @Autowired
    private HkhUploadMusicFileSerivce mscUpfileSerivce;

    @ResponseBody
    @RequestMapping("/upMusic")
    public Map<String,Object> uploadMp3(HttpServletRequest request, HttpServletResponse response,String MusicN,String singerName,MultipartFile file){
        Map<String, Object> result = new HashMap<String, Object>();
        String meesage = "";//报错信息
        System.out.println(file);
        try {
            if (file == null || file.getOriginalFilename() == null || "".equals(file.getOriginalFilename())) {
                return result;
            }
            System.out.println("MusicN="+MusicN+"||singerName="+singerName);
            List<Map<String,Object>> valmap = new ArrayList<Map<String,Object>>();
            valmap.add((Map)(new HashMap<String,Object>()).put("musicName",MusicN));
            valmap.add((Map)(new HashMap<String,Object>()).put("singerName",singerName));
            valmap.add((Map)(new HashMap<String,Object>()).put("mp3file","123"));
            if(file.getSize()>1024 * 1024 * 15){//不能大于15M
                meesage = "上传文件不能大于15M";
            }
            meesage =  mscUpfileSerivce.uploadMusicFile(valmap);
            result.put("message",meesage);
        }catch (Exception e){
            e.printStackTrace();
        }

        return  result;
    }

    public static void main(String[] args) {
        System.out.println(1);
    }

}
