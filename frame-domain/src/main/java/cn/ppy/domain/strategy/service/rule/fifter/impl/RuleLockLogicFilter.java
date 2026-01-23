package cn.ppy.domain.strategy.service.rule.fifter.impl;

import cn.ppy.domain.strategy.model.entity.RuleActionEntity;
import cn.ppy.domain.strategy.model.entity.RuleMatterEntity;
import cn.ppy.domain.strategy.model.valobj.RuleLogicCheckTypeVO;
import cn.ppy.domain.strategy.repository.IStrategyRepository;
import cn.ppy.domain.strategy.service.annotation.LogicStrategy;
import cn.ppy.domain.strategy.service.rule.fifter.ILogicFilter;
import cn.ppy.domain.strategy.service.rule.fifter.factory.DefaultLogicFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author wpy
 * @program: frame
 * @description: 抽奖中规则
 * @date 2026/1/22 19:54
 */
@Slf4j
@Component
@LogicStrategy(logicMode = DefaultLogicFactory.LogicModel.RULE_LOCK)
public class RuleLockLogicFilter implements ILogicFilter<RuleActionEntity.RaffleCenterEntity> {

    private Integer userCount = 0;

    @Resource
    private IStrategyRepository repository;
    @Override
    public RuleActionEntity<RuleActionEntity.RaffleCenterEntity> filter(RuleMatterEntity ruleMatterEntity) {
        //查询规则配置
        // 查询规则值配置
        String ruleValue = repository.queryStrategyRuleValue(ruleMatterEntity.getStrategyId(), ruleMatterEntity.getAwardId(), ruleMatterEntity.getRuleModel());

        //如果用户次数大于规则值，则返回不允许
        if (userCount < Integer.parseInt(ruleValue)) {
            return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                    .ruleModel(DefaultLogicFactory.LogicModel.RULE_LOCK.getCode())
                    .data(RuleActionEntity.RaffleCenterEntity.builder()
                            .strategyId(ruleMatterEntity.getStrategyId())
                            .awardId(ruleMatterEntity.getAwardId())
                            .build())
                    .code(RuleLogicCheckTypeVO.TAKE_OVER.getCode())
                    .info(RuleLogicCheckTypeVO.TAKE_OVER.getInfo())
                    .build();        }

        return RuleActionEntity.<RuleActionEntity.RaffleCenterEntity>builder()
                .code(RuleLogicCheckTypeVO.ALLOW.getCode())
                .info(RuleLogicCheckTypeVO.ALLOW.getInfo())
                .build();
    }
}
