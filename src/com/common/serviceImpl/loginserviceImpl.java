package common.serviceImpl;

import common.dao.loginDao;
import common.service.loginservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.Map;
@Service
public class loginserviceImpl implements loginservice {
    @Autowired
    private loginDao loginDao;
    @Override
    public Map<String, Object> checkpasword(Map<String, Object> map) {
        Map<String,Object> ret = loginDao.checkpasword(map);
        System.out.println("ret = "+ret);
        return ret;
    }
}
