package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysUserExample() {
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
     * <p>Description:  sys_user表的实体类 </p>
     * <p>Title: GeneratedCriteria </p>
     * <p>Create Time:2019-05-06 22:34 </p>
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

        public Criteria andSuIdIsNull() {
            addCriterion("su_id is null");
            return (Criteria) this;
        }

        public Criteria andSuIdIsNotNull() {
            addCriterion("su_id is not null");
            return (Criteria) this;
        }

        public Criteria andSuIdEqualTo(Integer value) {
            addCriterion("su_id =", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotEqualTo(Integer value) {
            addCriterion("su_id <>", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThan(Integer value) {
            addCriterion("su_id >", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("su_id >=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThan(Integer value) {
            addCriterion("su_id <", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdLessThanOrEqualTo(Integer value) {
            addCriterion("su_id <=", value, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdIn(List<Integer> values) {
            addCriterion("su_id in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotIn(List<Integer> values) {
            addCriterion("su_id not in", values, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdBetween(Integer value1, Integer value2) {
            addCriterion("su_id between", value1, value2, "suId");
            return (Criteria) this;
        }

        public Criteria andSuIdNotBetween(Integer value1, Integer value2) {
            addCriterion("su_id not between", value1, value2, "suId");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameIsNull() {
            addCriterion("su_login_name is null");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameIsNotNull() {
            addCriterion("su_login_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameEqualTo(String value) {
            addCriterion("su_login_name =", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameNotEqualTo(String value) {
            addCriterion("su_login_name <>", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameGreaterThan(String value) {
            addCriterion("su_login_name >", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameGreaterThanOrEqualTo(String value) {
            addCriterion("su_login_name >=", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameLessThan(String value) {
            addCriterion("su_login_name <", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameLessThanOrEqualTo(String value) {
            addCriterion("su_login_name <=", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameLike(String value) {
            addCriterion("su_login_name like", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameNotLike(String value) {
            addCriterion("su_login_name not like", value, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameIn(List<String> values) {
            addCriterion("su_login_name in", values, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameNotIn(List<String> values) {
            addCriterion("su_login_name not in", values, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameBetween(String value1, String value2) {
            addCriterion("su_login_name between", value1, value2, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuLoginNameNotBetween(String value1, String value2) {
            addCriterion("su_login_name not between", value1, value2, "suLoginName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameIsNull() {
            addCriterion("su_real_name is null");
            return (Criteria) this;
        }

        public Criteria andSuRealNameIsNotNull() {
            addCriterion("su_real_name is not null");
            return (Criteria) this;
        }

        public Criteria andSuRealNameEqualTo(String value) {
            addCriterion("su_real_name =", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameNotEqualTo(String value) {
            addCriterion("su_real_name <>", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameGreaterThan(String value) {
            addCriterion("su_real_name >", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("su_real_name >=", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameLessThan(String value) {
            addCriterion("su_real_name <", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameLessThanOrEqualTo(String value) {
            addCriterion("su_real_name <=", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameLike(String value) {
            addCriterion("su_real_name like", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameNotLike(String value) {
            addCriterion("su_real_name not like", value, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameIn(List<String> values) {
            addCriterion("su_real_name in", values, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameNotIn(List<String> values) {
            addCriterion("su_real_name not in", values, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameBetween(String value1, String value2) {
            addCriterion("su_real_name between", value1, value2, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuRealNameNotBetween(String value1, String value2) {
            addCriterion("su_real_name not between", value1, value2, "suRealName");
            return (Criteria) this;
        }

        public Criteria andSuPasswordIsNull() {
            addCriterion("su_password is null");
            return (Criteria) this;
        }

        public Criteria andSuPasswordIsNotNull() {
            addCriterion("su_password is not null");
            return (Criteria) this;
        }

        public Criteria andSuPasswordEqualTo(String value) {
            addCriterion("su_password =", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordNotEqualTo(String value) {
            addCriterion("su_password <>", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordGreaterThan(String value) {
            addCriterion("su_password >", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("su_password >=", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordLessThan(String value) {
            addCriterion("su_password <", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordLessThanOrEqualTo(String value) {
            addCriterion("su_password <=", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordLike(String value) {
            addCriterion("su_password like", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordNotLike(String value) {
            addCriterion("su_password not like", value, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordIn(List<String> values) {
            addCriterion("su_password in", values, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordNotIn(List<String> values) {
            addCriterion("su_password not in", values, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordBetween(String value1, String value2) {
            addCriterion("su_password between", value1, value2, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuPasswordNotBetween(String value1, String value2) {
            addCriterion("su_password not between", value1, value2, "suPassword");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeIsNull() {
            addCriterion("su_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeIsNotNull() {
            addCriterion("su_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeEqualTo(Date value) {
            addCriterion("su_create_time =", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeNotEqualTo(Date value) {
            addCriterion("su_create_time <>", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeGreaterThan(Date value) {
            addCriterion("su_create_time >", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("su_create_time >=", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeLessThan(Date value) {
            addCriterion("su_create_time <", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("su_create_time <=", value, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeIn(List<Date> values) {
            addCriterion("su_create_time in", values, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeNotIn(List<Date> values) {
            addCriterion("su_create_time not in", values, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeBetween(Date value1, Date value2) {
            addCriterion("su_create_time between", value1, value2, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("su_create_time not between", value1, value2, "suCreateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeIsNull() {
            addCriterion("su_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeIsNotNull() {
            addCriterion("su_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeEqualTo(Date value) {
            addCriterion("su_update_time =", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeNotEqualTo(Date value) {
            addCriterion("su_update_time <>", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeGreaterThan(Date value) {
            addCriterion("su_update_time >", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("su_update_time >=", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeLessThan(Date value) {
            addCriterion("su_update_time <", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("su_update_time <=", value, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeIn(List<Date> values) {
            addCriterion("su_update_time in", values, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeNotIn(List<Date> values) {
            addCriterion("su_update_time not in", values, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("su_update_time between", value1, value2, "suUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSuUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("su_update_time not between", value1, value2, "suUpdateTime");
            return (Criteria) this;
        }
    }

    /**
     * sys_user
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * <p>Description:  sys_user表的实体类 </p>
     * <p>Title: Criterion </p>
     * <p>Create Time:2019-05-06 22:34 </p>
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