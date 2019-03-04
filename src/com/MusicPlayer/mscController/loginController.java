package MusicPlayer.mscController;

import MusicPlayer.mscService.HkhMusicSerivce;
import com.sun.org.apache.xerces.internal.xs.datatypes.ObjectList;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private HkhMusicSerivce mscserivce;


    @RequestMapping("/queryMusicList")
    @ResponseBody
  public Map<String, Object> queryMusicList(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
     try {
        List<Map<String,Object>> musiclist = new ArrayList<Map<String,Object>>();
         musiclist  =  mscserivce.queryMusicList();
        result.put("MusicList", musiclist);
        System.out.println("queryMusicList-End");
      }catch (Exception e){
            e.printStackTrace();
      }
      return result;
  }

}
