package MusicPlayer.mscController;

import MusicPlayer.mscService.HkhMusicSerivce;
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

    @Autowired
    private HkhMusicSerivce mscQuerySerivce;

    @ResponseBody
    @RequestMapping("/upMusic")
    public Map<String,Object> uploadMp3(HttpServletRequest request, HttpServletResponse response,String MusicN,String singerName,MultipartFile file){
        Map<String, Object> result = new HashMap<String, Object>();
        String meesage = "";//报错信息
        try {
        //System.out.println(file);

            if (file == null || file.getOriginalFilename() == null || "".equals(file.getOriginalFilename())) {
                meesage = "请选择文件";
                result.put("message",meesage);
                return result;
            }
            System.out.println("MusicN="+MusicN+"||singerName="+singerName);
            Map<String,Object> valmap = new HashMap<String, Object>();
            /*List<Map<String,Object>> valmap = new ArrayList<Map<String,Object>>();
            valmap.add((Map)(new HashMap<String,Object>()).put("musicName",MusicN));
            valmap.add((Map)(new HashMap<String,Object>()).put("singerName",singerName));
            valmap.add((Map)(new HashMap<String,Object>()).put("mp3file","123"));*/
            valmap.put("musicName",MusicN);
            valmap.put("singerName",singerName);
            valmap.put("mp3file",file);
            if(file.getSize()>1024 * 1024 * 15){//不能大于15M
                meesage = "上传文件不能大于15M";
                result.put("message",meesage);
                return  result;
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
