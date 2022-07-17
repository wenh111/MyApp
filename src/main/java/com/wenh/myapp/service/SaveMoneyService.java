package com.wenh.myapp.service;

import com.wenh.myapp.entity.SaveMoneyEventBean;
import com.wenh.myapp.entity.SaveMoneyEventListBean;
import com.wenh.myapp.entity.UDSaveMoneyEventBean;
import com.wenh.myapp.mapper.SaveMoneyEventMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SaveMoneyService {
    @Autowired
    SaveMoneyEventMapper saveMoneyEventMapper;

    public int insertSaveMoneyEvent(SaveMoneyEventBean saveMoneyEventBean) {
        return saveMoneyEventMapper.insertSaveMoneyEvent(saveMoneyEventBean);
    }

    public SaveMoneyEventListBean selectAllSaveMoneyEvent() {

        List<SaveMoneyEventBean> saveMoneyEventBean = saveMoneyEventMapper.selectAllSaveMoneyEvent();
        int count = saveMoneyEventBean.size();
        return new SaveMoneyEventListBean(count, saveMoneyEventBean);
    }

    public SaveMoneyEventListBean selectAllSaveMoneyPlanEvent(String account, String type) {
        List<SaveMoneyEventBean> saveMoneyEventBean = saveMoneyEventMapper.selectAllSaveMoneyPlanEvent(account, type);
        int count = saveMoneyEventBean.size();
        return new SaveMoneyEventListBean(count, saveMoneyEventBean);
    }

    public int punchCard(UDSaveMoneyEventBean udSaveMoneyEventBean, int isDelete) {
        int count = 0;
        if (isDelete == 1) {
            count = saveMoneyEventMapper.deleteSaveMoneyPlanEven(udSaveMoneyEventBean.getId());
        } else if (isDelete == -1) {
            count = saveMoneyEventMapper.updateSaveMoneyPlanEven(udSaveMoneyEventBean.getDate(), udSaveMoneyEventBean.getId(),
                    udSaveMoneyEventBean.getRemainingTimes(), udSaveMoneyEventBean.getSavedMoney());
        }
        return count;
    }
}
