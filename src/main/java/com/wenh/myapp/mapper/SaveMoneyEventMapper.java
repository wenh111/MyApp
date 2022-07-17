package com.wenh.myapp.mapper;

import com.wenh.myapp.entity.SaveMoneyEventBean;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SaveMoneyEventMapper {

    int insertSaveMoneyEvent(SaveMoneyEventBean saveMoneyEventBean);

    List<SaveMoneyEventBean> selectAllSaveMoneyEvent();

    List<SaveMoneyEventBean> selectAllSaveMoneyPlanEvent(@Param("account" )String account, @Param("type" )String type);

    int deleteSaveMoneyPlanEven(@Param("id" )int id);

    int updateSaveMoneyPlanEven(@Param("date" )String date,@Param("id" )int id,
                                @Param("remainingTimes" )int remainingTimes,@Param("savedMoney" )double savedMoney);
}
