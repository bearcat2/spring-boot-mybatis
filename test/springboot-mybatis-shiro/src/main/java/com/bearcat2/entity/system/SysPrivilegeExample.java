package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysPrivilegeExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysPrivilegeExample() {
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
     * <p>Description:  sys_privilege表的实体类 </p>
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

        public Criteria andSpIdIsNull() {
            addCriterion("sp_id is null");
            return (Criteria) this;
        }

        public Criteria andSpIdIsNotNull() {
            addCriterion("sp_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpIdEqualTo(Integer value) {
            addCriterion("sp_id =", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotEqualTo(Integer value) {
            addCriterion("sp_id <>", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThan(Integer value) {
            addCriterion("sp_id >", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_id >=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThan(Integer value) {
            addCriterion("sp_id <", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_id <=", value, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdIn(List<Integer> values) {
            addCriterion("sp_id in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotIn(List<Integer> values) {
            addCriterion("sp_id not in", values, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_id between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_id not between", value1, value2, "spId");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNull() {
            addCriterion("sp_name is null");
            return (Criteria) this;
        }

        public Criteria andSpNameIsNotNull() {
            addCriterion("sp_name is not null");
            return (Criteria) this;
        }

        public Criteria andSpNameEqualTo(String value) {
            addCriterion("sp_name =", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotEqualTo(String value) {
            addCriterion("sp_name <>", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThan(String value) {
            addCriterion("sp_name >", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameGreaterThanOrEqualTo(String value) {
            addCriterion("sp_name >=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThan(String value) {
            addCriterion("sp_name <", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLessThanOrEqualTo(String value) {
            addCriterion("sp_name <=", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameLike(String value) {
            addCriterion("sp_name like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotLike(String value) {
            addCriterion("sp_name not like", value, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameIn(List<String> values) {
            addCriterion("sp_name in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotIn(List<String> values) {
            addCriterion("sp_name not in", values, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameBetween(String value1, String value2) {
            addCriterion("sp_name between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpNameNotBetween(String value1, String value2) {
            addCriterion("sp_name not between", value1, value2, "spName");
            return (Criteria) this;
        }

        public Criteria andSpUriIsNull() {
            addCriterion("sp_uri is null");
            return (Criteria) this;
        }

        public Criteria andSpUriIsNotNull() {
            addCriterion("sp_uri is not null");
            return (Criteria) this;
        }

        public Criteria andSpUriEqualTo(String value) {
            addCriterion("sp_uri =", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriNotEqualTo(String value) {
            addCriterion("sp_uri <>", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriGreaterThan(String value) {
            addCriterion("sp_uri >", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriGreaterThanOrEqualTo(String value) {
            addCriterion("sp_uri >=", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriLessThan(String value) {
            addCriterion("sp_uri <", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriLessThanOrEqualTo(String value) {
            addCriterion("sp_uri <=", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriLike(String value) {
            addCriterion("sp_uri like", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriNotLike(String value) {
            addCriterion("sp_uri not like", value, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriIn(List<String> values) {
            addCriterion("sp_uri in", values, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriNotIn(List<String> values) {
            addCriterion("sp_uri not in", values, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriBetween(String value1, String value2) {
            addCriterion("sp_uri between", value1, value2, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpUriNotBetween(String value1, String value2) {
            addCriterion("sp_uri not between", value1, value2, "spUri");
            return (Criteria) this;
        }

        public Criteria andSpTypeIsNull() {
            addCriterion("sp_type is null");
            return (Criteria) this;
        }

        public Criteria andSpTypeIsNotNull() {
            addCriterion("sp_type is not null");
            return (Criteria) this;
        }

        public Criteria andSpTypeEqualTo(Integer value) {
            addCriterion("sp_type =", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotEqualTo(Integer value) {
            addCriterion("sp_type <>", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThan(Integer value) {
            addCriterion("sp_type >", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_type >=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThan(Integer value) {
            addCriterion("sp_type <", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeLessThanOrEqualTo(Integer value) {
            addCriterion("sp_type <=", value, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeIn(List<Integer> values) {
            addCriterion("sp_type in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotIn(List<Integer> values) {
            addCriterion("sp_type not in", values, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeBetween(Integer value1, Integer value2) {
            addCriterion("sp_type between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andSpTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_type not between", value1, value2, "spType");
            return (Criteria) this;
        }

        public Criteria andSpParentIdIsNull() {
            addCriterion("sp_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andSpParentIdIsNotNull() {
            addCriterion("sp_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andSpParentIdEqualTo(Integer value) {
            addCriterion("sp_parent_id =", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdNotEqualTo(Integer value) {
            addCriterion("sp_parent_id <>", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdGreaterThan(Integer value) {
            addCriterion("sp_parent_id >", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_parent_id >=", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdLessThan(Integer value) {
            addCriterion("sp_parent_id <", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_parent_id <=", value, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdIn(List<Integer> values) {
            addCriterion("sp_parent_id in", values, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdNotIn(List<Integer> values) {
            addCriterion("sp_parent_id not in", values, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdBetween(Integer value1, Integer value2) {
            addCriterion("sp_parent_id between", value1, value2, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_parent_id not between", value1, value2, "spParentId");
            return (Criteria) this;
        }

        public Criteria andSpOrderdIsNull() {
            addCriterion("sp_orderd is null");
            return (Criteria) this;
        }

        public Criteria andSpOrderdIsNotNull() {
            addCriterion("sp_orderd is not null");
            return (Criteria) this;
        }

        public Criteria andSpOrderdEqualTo(Integer value) {
            addCriterion("sp_orderd =", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdNotEqualTo(Integer value) {
            addCriterion("sp_orderd <>", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdGreaterThan(Integer value) {
            addCriterion("sp_orderd >", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sp_orderd >=", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdLessThan(Integer value) {
            addCriterion("sp_orderd <", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdLessThanOrEqualTo(Integer value) {
            addCriterion("sp_orderd <=", value, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdIn(List<Integer> values) {
            addCriterion("sp_orderd in", values, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdNotIn(List<Integer> values) {
            addCriterion("sp_orderd not in", values, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdBetween(Integer value1, Integer value2) {
            addCriterion("sp_orderd between", value1, value2, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpOrderdNotBetween(Integer value1, Integer value2) {
            addCriterion("sp_orderd not between", value1, value2, "spOrderd");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeIsNull() {
            addCriterion("sp_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeIsNotNull() {
            addCriterion("sp_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeEqualTo(Date value) {
            addCriterion("sp_create_time =", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeNotEqualTo(Date value) {
            addCriterion("sp_create_time <>", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeGreaterThan(Date value) {
            addCriterion("sp_create_time >", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sp_create_time >=", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeLessThan(Date value) {
            addCriterion("sp_create_time <", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sp_create_time <=", value, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeIn(List<Date> values) {
            addCriterion("sp_create_time in", values, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeNotIn(List<Date> values) {
            addCriterion("sp_create_time not in", values, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeBetween(Date value1, Date value2) {
            addCriterion("sp_create_time between", value1, value2, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sp_create_time not between", value1, value2, "spCreateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeIsNull() {
            addCriterion("sp_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeIsNotNull() {
            addCriterion("sp_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeEqualTo(Date value) {
            addCriterion("sp_update_time =", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeNotEqualTo(Date value) {
            addCriterion("sp_update_time <>", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeGreaterThan(Date value) {
            addCriterion("sp_update_time >", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("sp_update_time >=", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeLessThan(Date value) {
            addCriterion("sp_update_time <", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("sp_update_time <=", value, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeIn(List<Date> values) {
            addCriterion("sp_update_time in", values, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeNotIn(List<Date> values) {
            addCriterion("sp_update_time not in", values, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("sp_update_time between", value1, value2, "spUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSpUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("sp_update_time not between", value1, value2, "spUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * sys_privilege
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * <p>Description:  sys_privilege表的实体类 </p>
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