package cn.ppy.domain.strategy.repository;

import cn.ppy.domain.strategy.model.entity.StrategyAwardEntity;
import cn.ppy.domain.strategy.model.entity.StrategyEntity;
import cn.ppy.domain.strategy.model.entity.StrategyRuleEntity;
import cn.ppy.domain.strategy.model.valobj.RuleTreeVO;
import cn.ppy.domain.strategy.model.valobj.StrategyAwardRuleModelVO;
import cn.ppy.domain.strategy.model.valobj.StrategyAwardStockKeyVO;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author Fuzhengwei ppy.cn @小傅哥
 * @description 策略服务仓储接口
 * @create 2023-12-23 09:33
 */
public interface IStrategyRepository {

    List<StrategyAwardEntity> queryStrategyAwardList(Long strategyId);

    void storeStrategyAwardSearchRateTable(String key, Integer rateRange, Map<Integer, Integer> strategyAwardSearchRateTable);

    Integer getStrategyAwardAssemble(String key, Integer rateKey);

    int getRateRange(String key);

    int getRateRange(Long strategyId);

    StrategyEntity queryStrategyEntityByStrategyId(Long strategyId);

    StrategyRuleEntity queryStrategyRule(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, String ruleModel);

    String queryStrategyRuleValue(Long strategyId, Integer awardId, String ruleModel);

    StrategyAwardRuleModelVO queryStrategyAwardRuleModelVO(Long strategyId, Integer awardId);

    RuleTreeVO queryRuleTreeVOByTreeId(String ruleModels);

    void cacheStrategyAwardCount(String cacheKey, Integer awardCount);

    void awardStockConsumeSendQueue(StrategyAwardStockKeyVO build);

    Boolean subtractionAwardStock(String cacheKey);
}
