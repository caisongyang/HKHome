package MusicPlayer.mscController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/upload")
public class upMp3Contrroller {

    @ResponseBody
    @RequestMapping("/upMusic")
    public static Map<String,Object> uploadMp3(HttpServletRequest request, HttpServletResponse response, MultipartFile file){
        Map<String, Object> result = new HashMap<String, Object>();
        String meesage = "";//报错信息·
        try {
            if (file == null || file.getOriginalFilename() == null || "".equals(file.getOriginalFilename())) {
                return result;
            }
            Map<String,Object> valmap = new HashMap<>();
            valmap.put("musicName",request.getParameter("mscName"));
            valmap.put("singerName",request.getParameter("mscsingerName"));
            valmap.put("mp3file",file);
            String fileName = file.getOriginalFilename();
            InputStream inputStream = file.getInputStream();
            if(file.getSize()>1024 * 1024 * 15){//不能大于15M
                meesage = "上传文件不能大于15M";
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        return  result;
    }

}
