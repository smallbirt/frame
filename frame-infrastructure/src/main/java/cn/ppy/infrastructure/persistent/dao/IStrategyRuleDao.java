package cn.ppy.infrastructure.persistent.dao;

import cn.ppy.infrastructure.persistent.po.Strategy;
import cn.ppy.infrastructure.persistent.po.StrategyRule;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fuzhengwei ppy.cn @小傅哥
 * @description 策略规则 DAO
 * @create 2023-12-16 13:25
 */
@Mapper
public interface IStrategyRuleDao {

    List<StrategyRule> queryStrategyRuleList();

    StrategyRule queryStrategyRule(StrategyRule strategyRuleReq);
}
