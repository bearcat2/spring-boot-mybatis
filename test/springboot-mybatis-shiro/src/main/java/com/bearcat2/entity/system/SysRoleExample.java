package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysRoleExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysRoleExample() {
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
     * <p>Description:  sys_role表的实体类 </p>
     * <p>Title: GeneratedCriteria </p>
     * <p>Create Time:2019-05-11 21:01 </p>
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

        public Criteria andSrIdIsNull() {
            addCriterion("sr_id is null");
            return (Criteria) this;
        }

        public Criteria andSrIdIsNotNull() {
            addCriterion("sr_id is not null");
            return (Criteria) this;
        }

        public Criteria andSrIdEqualTo(Integer value) {
            addCriterion("sr_id =", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotEqualTo(Integer value) {
            addCriterion("sr_id <>", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdGreaterThan(Integer value) {
            addCriterion("sr_id >", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sr_id >=", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdLessThan(Integer value) {
            addCriterion("sr_id <", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdLessThanOrEqualTo(Integer value) {
            addCriterion("sr_id <=", value, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdIn(List<Integer> values) {
            addCriterion("sr_id in", values, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotIn(List<Integer> values) {
            addCriterion("sr_id not in", values, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdBetween(Integer value1, Integer value2) {
            addCriterion("sr_id between", value1, value2, "srId");
            return (Criteria) this;
        }

        public Criteria andSrIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sr_id not between", value1, value2, "srId");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNull() {
            addCriterion("sr_name is null");
            return (Criteria) this;
        }

        public Criteria andSrNameIsNotNull() {
            addCriterion("sr_name is not null");
            return (Criteria) this;
        }

        public Criteria andSrNameEqualTo(String value) {
            addCriterion("sr_name =", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotEqualTo(String value) {
            addCriterion("sr_name <>", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThan(String value) {
            addCriterion("sr_name >", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameGreaterThanOrEqualTo(String value) {
            addCriterion("sr_name >=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThan(String value) {
            addCriterion("sr_name <", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLessThanOrEqualTo(String value) {
            addCriterion("sr_name <=", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameLike(String value) {
            addCriterion("sr_name like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotLike(String value) {
            addCriterion("sr_name not like", value, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameIn(List<String> values) {
            addCriterion("sr_name in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotIn(List<String> values) {
            addCriterion("sr_name not in", values, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameBetween(String value1, String value2) {
            addCriterion("sr_name between", value1, value2, "srName");
            return (Criteria) this;
        }

        public Criteria andSrNameNotBetween(String value1, String value2) {
            addCriterion("sr_name not between", value1, value2, "srName");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionIsNull() {
            addCriterion("sr_description is null");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionIsNotNull() {
            addCriterion("sr_description is not null");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionEqualTo(String value) {
            addCriterion("sr_description =", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionNotEqualTo(String value) {
            addCriterion("sr_description <>", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionGreaterThan(String value) {
            addCriterion("sr_description >", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("sr_description >=", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionLessThan(String value) {
            addCriterion("sr_description <", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionLessThanOrEqualTo(String value) {
            addCriterion("sr_description <=", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionLike(String value) {
            addCriterion("sr_description like", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionNotLike(String value) {
            addCriterion("sr_description not like", value, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionIn(List<String> values) {
            addCriterion("sr_description in", values, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionNotIn(List<String> values) {
            addCriterion("sr_description not in", values, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionBetween(String value1, String value2) {
            addCriterion("sr_description between", value1, value2, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrDescriptionNotBetween(String value1, String value2) {
            addCriterion("sr_description not between", value1, value2, "srDescription");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeIsNull() {
            addCriterion("sr_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeIsNotNull() {
            addCriterion("sr_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeEqualTo(Date value) {
            addCriterion("sr_create_time =", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeNotEqualTo(Date value) {
            addCriterion("sr_create_time <>", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeGreaterThan(Date value) {
            addCriterion("sr_create_time >", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sr_create_time >=", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeLessThan(Date value) {
            addCriterion("sr_create_time <", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sr_create_time <=", value, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeIn(List<Date> values) {
            addCriterion("sr_create_time in", values, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeNotIn(List<Date> values) {
            addCriterion("sr_create_time not in", values, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sr_create_time between", value1, value2, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sr_create_time not between", value1, value2, "srCreateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeIsNull() {
            addCriterion("sr_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeIsNotNull() {
            addCriterion("sr_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeEqualTo(Date value) {
            addCriterion("sr_update_time =", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeNotEqualTo(Date value) {
            addCriterion("sr_update_time <>", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeGreaterThan(Date value) {
            addCriterion("sr_update_time >", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sr_update_time >=", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeLessThan(Date value) {
            addCriterion("sr_update_time <", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sr_update_time <=", value, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeIn(List<Date> values) {
            addCriterion("sr_update_time in", values, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeNotIn(List<Date> values) {
            addCriterion("sr_update_time not in", values, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("sr_update_time between", value1, value2, "srUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSrUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sr_update_time not between", value1, value2, "srUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * sys_role
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * <p>Description:  sys_role表的实体类 </p>
     * <p>Title: Criterion </p>
     * <p>Create Time:2019-05-11 21:01 </p>
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