package cn.ppy.domain.strategy.service.armory;

/**
 * @author Fuzhengwei ppy.cn @小傅哥
 * @description 策略装配库(兵工厂)，负责初始化策略计算
 * @create 2023-12-23 09:44
 */
public interface IStrategyDispatch {

    /**
     * 获取抽奖策略装配的随机结果
     *
     * @param strategyId 策略ID
     * @return 抽奖结果
     */
    Integer getRandomAwardId(Long strategyId);

    /**
     * 获取抽奖策略装配的积分累计结果
     * @param strategyId
     * @param ruleWeightValue
     * @return
     */
    Integer getRandomAwardId(Long strategyId, String ruleWeightValue);

}
