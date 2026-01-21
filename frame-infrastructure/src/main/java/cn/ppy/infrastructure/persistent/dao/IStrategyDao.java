package cn.ppy.infrastructure.persistent.dao;

import cn.ppy.infrastructure.persistent.po.Strategy;
import cn.ppy.infrastructure.persistent.po.StrategyAward;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author Fuzhengwei ppy.cn @小傅哥
 * @description 抽奖策略 DAO
 * @create 2023-12-16 13:24
 */
@Mapper
public interface IStrategyDao {

    List<Strategy> queryStrategyList();

    Strategy queryStrategyByStrategyId(Long strategyId);
}
