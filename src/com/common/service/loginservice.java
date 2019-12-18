package common.service;

import java.util.Map;

public interface loginservice {

    public Map<String,Object> checkpasword(Map<String,Object> map) throws Exception;

    public Map<String,Object> newloginUser(Map<String,Object> map) throws Exception;

}
