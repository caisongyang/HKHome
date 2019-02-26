package MusicPlayer.mscController;

import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/login")
public class loginController {


    @RequestMapping("/queryMusicList")
    @ResponseBody
  public Map<String, Object> queryMusicList(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
     try {
        List<Map<String,Object>> musiclist= new ArrayList<Map<String, Object>>();
        Map<String,Object> music = new HashMap<String,Object>();
        music.put("从你的全世界路过","a-s");
        musiclist.add(music);
        result.put("MusicList", musiclist);
        System.out.println("queryMusicList12");


      }catch (Exception e){
            e.printStackTrace();
      }
      return result;
  }

}
