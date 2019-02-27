package MusicPlayer.mscServiceImpl;

import MusicPlayer.mscDao.HkhMusicDao;
import MusicPlayer.mscService.HkhMusicSerivce;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public class HkhMusicSerivceImpl implements HkhMusicSerivce {
    @Autowired
    private HkhMusicDao mscDao;

    @Override
    public List<Map<String, Object>> queryMusicList() {
        return mscDao.queryMusicList();
    }
}
