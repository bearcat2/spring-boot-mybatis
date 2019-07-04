package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysDataDictionaryExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysDataDictionaryExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * <p>Description:  sys_data_dictionary表的实体类 </p>
     * <p>Title: GeneratedCriteria </p>
     * <p>Create Time:2019-05-12 11:25 </p>
     *
     * @author: mybatis generator
     * @version: 1.0
     */
    protected abstract static class GeneratedCriteria implements Serializable {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andSdrIdIsNull() {
            addCriterion("sdr_id is null");
            return (Criteria) this;
        }

        public Criteria andSdrIdIsNotNull() {
            addCriterion("sdr_id is not null");
            return (Criteria) this;
        }

        public Criteria andSdrIdEqualTo(Integer value) {
            addCriterion("sdr_id =", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdNotEqualTo(Integer value) {
            addCriterion("sdr_id <>", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdGreaterThan(Integer value) {
            addCriterion("sdr_id >", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdr_id >=", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdLessThan(Integer value) {
            addCriterion("sdr_id <", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdLessThanOrEqualTo(Integer value) {
            addCriterion("sdr_id <=", value, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdIn(List<Integer> values) {
            addCriterion("sdr_id in", values, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdNotIn(List<Integer> values) {
            addCriterion("sdr_id not in", values, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdBetween(Integer value1, Integer value2) {
            addCriterion("sdr_id between", value1, value2, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sdr_id not between", value1, value2, "sdrId");
            return (Criteria) this;
        }

        public Criteria andSdrNameIsNull() {
            addCriterion("sdr_name is null");
            return (Criteria) this;
        }

        public Criteria andSdrNameIsNotNull() {
            addCriterion("sdr_name is not null");
            return (Criteria) this;
        }

        public Criteria andSdrNameEqualTo(String value) {
            addCriterion("sdr_name =", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameNotEqualTo(String value) {
            addCriterion("sdr_name <>", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameGreaterThan(String value) {
            addCriterion("sdr_name >", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameGreaterThanOrEqualTo(String value) {
            addCriterion("sdr_name >=", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameLessThan(String value) {
            addCriterion("sdr_name <", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameLessThanOrEqualTo(String value) {
            addCriterion("sdr_name <=", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameLike(String value) {
            addCriterion("sdr_name like", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameNotLike(String value) {
            addCriterion("sdr_name not like", value, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameIn(List<String> values) {
            addCriterion("sdr_name in", values, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameNotIn(List<String> values) {
            addCriterion("sdr_name not in", values, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameBetween(String value1, String value2) {
            addCriterion("sdr_name between", value1, value2, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrNameNotBetween(String value1, String value2) {
            addCriterion("sdr_name not between", value1, value2, "sdrName");
            return (Criteria) this;
        }

        public Criteria andSdrValueIsNull() {
            addCriterion("sdr_value is null");
            return (Criteria) this;
        }

        public Criteria andSdrValueIsNotNull() {
            addCriterion("sdr_value is not null");
            return (Criteria) this;
        }

        public Criteria andSdrValueEqualTo(String value) {
            addCriterion("sdr_value =", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueNotEqualTo(String value) {
            addCriterion("sdr_value <>", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueGreaterThan(String value) {
            addCriterion("sdr_value >", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueGreaterThanOrEqualTo(String value) {
            addCriterion("sdr_value >=", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueLessThan(String value) {
            addCriterion("sdr_value <", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueLessThanOrEqualTo(String value) {
            addCriterion("sdr_value <=", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueLike(String value) {
            addCriterion("sdr_value like", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueNotLike(String value) {
            addCriterion("sdr_value not like", value, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueIn(List<String> values) {
            addCriterion("sdr_value in", values, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueNotIn(List<String> values) {
            addCriterion("sdr_value not in", values, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueBetween(String value1, String value2) {
            addCriterion("sdr_value between", value1, value2, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrValueNotBetween(String value1, String value2) {
            addCriterion("sdr_value not between", value1, value2, "sdrValue");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdIsNull() {
            addCriterion("sdr_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdIsNotNull() {
            addCriterion("sdr_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdEqualTo(Integer value) {
            addCriterion("sdr_parent_id =", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdNotEqualTo(Integer value) {
            addCriterion("sdr_parent_id <>", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdGreaterThan(Integer value) {
            addCriterion("sdr_parent_id >", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdr_parent_id >=", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdLessThan(Integer value) {
            addCriterion("sdr_parent_id <", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("sdr_parent_id <=", value, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdIn(List<Integer> values) {
            addCriterion("sdr_parent_id in", values, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdNotIn(List<Integer> values) {
            addCriterion("sdr_parent_id not in", values, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdBetween(Integer value1, Integer value2) {
            addCriterion("sdr_parent_id between", value1, value2, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sdr_parent_id not between", value1, value2, "sdrParentId");
            return (Criteria) this;
        }

        public Criteria andSdrLevelIsNull() {
            addCriterion("sdr_level is null");
            return (Criteria) this;
        }

        public Criteria andSdrLevelIsNotNull() {
            addCriterion("sdr_level is not null");
            return (Criteria) this;
        }

        public Criteria andSdrLevelEqualTo(Integer value) {
            addCriterion("sdr_level =", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelNotEqualTo(Integer value) {
            addCriterion("sdr_level <>", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelGreaterThan(Integer value) {
            addCriterion("sdr_level >", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdr_level >=", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelLessThan(Integer value) {
            addCriterion("sdr_level <", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelLessThanOrEqualTo(Integer value) {
            addCriterion("sdr_level <=", value, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelIn(List<Integer> values) {
            addCriterion("sdr_level in", values, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelNotIn(List<Integer> values) {
            addCriterion("sdr_level not in", values, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelBetween(Integer value1, Integer value2) {
            addCriterion("sdr_level between", value1, value2, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrLevelNotBetween(Integer value1, Integer value2) {
            addCriterion("sdr_level not between", value1, value2, "sdrLevel");
            return (Criteria) this;
        }

        public Criteria andSdrOrderIsNull() {
            addCriterion("sdr_order is null");
            return (Criteria) this;
        }

        public Criteria andSdrOrderIsNotNull() {
            addCriterion("sdr_order is not null");
            return (Criteria) this;
        }

        public Criteria andSdrOrderEqualTo(Integer value) {
            addCriterion("sdr_order =", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderNotEqualTo(Integer value) {
            addCriterion("sdr_order <>", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderGreaterThan(Integer value) {
            addCriterion("sdr_order >", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderGreaterThanOrEqualTo(Integer value) {
            addCriterion("sdr_order >=", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderLessThan(Integer value) {
            addCriterion("sdr_order <", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderLessThanOrEqualTo(Integer value) {
            addCriterion("sdr_order <=", value, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderIn(List<Integer> values) {
            addCriterion("sdr_order in", values, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderNotIn(List<Integer> values) {
            addCriterion("sdr_order not in", values, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderBetween(Integer value1, Integer value2) {
            addCriterion("sdr_order between", value1, value2, "sdrOrder");
            return (Criteria) this;
        }

        public Criteria andSdrOrderNotBetween(Integer value1, Integer value2) {
            addCriterion("sdr_order not between", value1, value2, "sdrOrder");
            return (Criteria) this;
        }
    }

    /**
     * sys_data_dictionary
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * <p>Description:  sys_data_dictionary表的实体类 </p>
     * <p>Title: Criterion </p>
     * <p>Create Time:2019-05-12 11:25 </p>
     *
     * @author: mybatis generator
     * @version: 1.0
     */
    public static class Criterion implements Serializable {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}