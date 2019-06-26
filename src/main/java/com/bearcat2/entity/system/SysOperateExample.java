package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysOperateExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysOperateExample() {
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

        public Criteria andSoIdIsNull() {
            addCriterion("so_id is null");
            return (Criteria) this;
        }

        public Criteria andSoIdIsNotNull() {
            addCriterion("so_id is not null");
            return (Criteria) this;
        }

        public Criteria andSoIdEqualTo(Integer value) {
            addCriterion("so_id =", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotEqualTo(Integer value) {
            addCriterion("so_id <>", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdGreaterThan(Integer value) {
            addCriterion("so_id >", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("so_id >=", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdLessThan(Integer value) {
            addCriterion("so_id <", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdLessThanOrEqualTo(Integer value) {
            addCriterion("so_id <=", value, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdIn(List<Integer> values) {
            addCriterion("so_id in", values, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotIn(List<Integer> values) {
            addCriterion("so_id not in", values, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdBetween(Integer value1, Integer value2) {
            addCriterion("so_id between", value1, value2, "soId");
            return (Criteria) this;
        }

        public Criteria andSoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("so_id not between", value1, value2, "soId");
            return (Criteria) this;
        }

        public Criteria andSoNameIsNull() {
            addCriterion("so_name is null");
            return (Criteria) this;
        }

        public Criteria andSoNameIsNotNull() {
            addCriterion("so_name is not null");
            return (Criteria) this;
        }

        public Criteria andSoNameEqualTo(String value) {
            addCriterion("so_name =", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameNotEqualTo(String value) {
            addCriterion("so_name <>", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameGreaterThan(String value) {
            addCriterion("so_name >", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameGreaterThanOrEqualTo(String value) {
            addCriterion("so_name >=", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameLessThan(String value) {
            addCriterion("so_name <", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameLessThanOrEqualTo(String value) {
            addCriterion("so_name <=", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameLike(String value) {
            addCriterion("so_name like", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameNotLike(String value) {
            addCriterion("so_name not like", value, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameIn(List<String> values) {
            addCriterion("so_name in", values, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameNotIn(List<String> values) {
            addCriterion("so_name not in", values, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameBetween(String value1, String value2) {
            addCriterion("so_name between", value1, value2, "soName");
            return (Criteria) this;
        }

        public Criteria andSoNameNotBetween(String value1, String value2) {
            addCriterion("so_name not between", value1, value2, "soName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameIsNull() {
            addCriterion("so_show_name is null");
            return (Criteria) this;
        }

        public Criteria andSoShowNameIsNotNull() {
            addCriterion("so_show_name is not null");
            return (Criteria) this;
        }

        public Criteria andSoShowNameEqualTo(String value) {
            addCriterion("so_show_name =", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameNotEqualTo(String value) {
            addCriterion("so_show_name <>", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameGreaterThan(String value) {
            addCriterion("so_show_name >", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameGreaterThanOrEqualTo(String value) {
            addCriterion("so_show_name >=", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameLessThan(String value) {
            addCriterion("so_show_name <", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameLessThanOrEqualTo(String value) {
            addCriterion("so_show_name <=", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameLike(String value) {
            addCriterion("so_show_name like", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameNotLike(String value) {
            addCriterion("so_show_name not like", value, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameIn(List<String> values) {
            addCriterion("so_show_name in", values, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameNotIn(List<String> values) {
            addCriterion("so_show_name not in", values, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameBetween(String value1, String value2) {
            addCriterion("so_show_name between", value1, value2, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoShowNameNotBetween(String value1, String value2) {
            addCriterion("so_show_name not between", value1, value2, "soShowName");
            return (Criteria) this;
        }

        public Criteria andSoOrderdIsNull() {
            addCriterion("so_orderd is null");
            return (Criteria) this;
        }

        public Criteria andSoOrderdIsNotNull() {
            addCriterion("so_orderd is not null");
            return (Criteria) this;
        }

        public Criteria andSoOrderdEqualTo(Integer value) {
            addCriterion("so_orderd =", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdNotEqualTo(Integer value) {
            addCriterion("so_orderd <>", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdGreaterThan(Integer value) {
            addCriterion("so_orderd >", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdGreaterThanOrEqualTo(Integer value) {
            addCriterion("so_orderd >=", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdLessThan(Integer value) {
            addCriterion("so_orderd <", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdLessThanOrEqualTo(Integer value) {
            addCriterion("so_orderd <=", value, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdIn(List<Integer> values) {
            addCriterion("so_orderd in", values, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdNotIn(List<Integer> values) {
            addCriterion("so_orderd not in", values, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdBetween(Integer value1, Integer value2) {
            addCriterion("so_orderd between", value1, value2, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoOrderdNotBetween(Integer value1, Integer value2) {
            addCriterion("so_orderd not between", value1, value2, "soOrderd");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeIsNull() {
            addCriterion("so_create_time is null");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeIsNotNull() {
            addCriterion("so_create_time is not null");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeEqualTo(Date value) {
            addCriterion("so_create_time =", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeNotEqualTo(Date value) {
            addCriterion("so_create_time <>", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeGreaterThan(Date value) {
            addCriterion("so_create_time >", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("so_create_time >=", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeLessThan(Date value) {
            addCriterion("so_create_time <", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("so_create_time <=", value, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeIn(List<Date> values) {
            addCriterion("so_create_time in", values, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeNotIn(List<Date> values) {
            addCriterion("so_create_time not in", values, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeBetween(Date value1, Date value2) {
            addCriterion("so_create_time between", value1, value2, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("so_create_time not between", value1, value2, "soCreateTime");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserIsNull() {
            addCriterion("so_create_user is null");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserIsNotNull() {
            addCriterion("so_create_user is not null");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserEqualTo(String value) {
            addCriterion("so_create_user =", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserNotEqualTo(String value) {
            addCriterion("so_create_user <>", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserGreaterThan(String value) {
            addCriterion("so_create_user >", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserGreaterThanOrEqualTo(String value) {
            addCriterion("so_create_user >=", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserLessThan(String value) {
            addCriterion("so_create_user <", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserLessThanOrEqualTo(String value) {
            addCriterion("so_create_user <=", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserLike(String value) {
            addCriterion("so_create_user like", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserNotLike(String value) {
            addCriterion("so_create_user not like", value, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserIn(List<String> values) {
            addCriterion("so_create_user in", values, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserNotIn(List<String> values) {
            addCriterion("so_create_user not in", values, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserBetween(String value1, String value2) {
            addCriterion("so_create_user between", value1, value2, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoCreateUserNotBetween(String value1, String value2) {
            addCriterion("so_create_user not between", value1, value2, "soCreateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeIsNull() {
            addCriterion("so_update_time is null");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeIsNotNull() {
            addCriterion("so_update_time is not null");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeEqualTo(Date value) {
            addCriterion("so_update_time =", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeNotEqualTo(Date value) {
            addCriterion("so_update_time <>", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeGreaterThan(Date value) {
            addCriterion("so_update_time >", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("so_update_time >=", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeLessThan(Date value) {
            addCriterion("so_update_time <", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("so_update_time <=", value, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeIn(List<Date> values) {
            addCriterion("so_update_time in", values, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeNotIn(List<Date> values) {
            addCriterion("so_update_time not in", values, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("so_update_time between", value1, value2, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("so_update_time not between", value1, value2, "soUpdateTime");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserIsNull() {
            addCriterion("so_update_user is null");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserIsNotNull() {
            addCriterion("so_update_user is not null");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserEqualTo(String value) {
            addCriterion("so_update_user =", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserNotEqualTo(String value) {
            addCriterion("so_update_user <>", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserGreaterThan(String value) {
            addCriterion("so_update_user >", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserGreaterThanOrEqualTo(String value) {
            addCriterion("so_update_user >=", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserLessThan(String value) {
            addCriterion("so_update_user <", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserLessThanOrEqualTo(String value) {
            addCriterion("so_update_user <=", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserLike(String value) {
            addCriterion("so_update_user like", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserNotLike(String value) {
            addCriterion("so_update_user not like", value, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserIn(List<String> values) {
            addCriterion("so_update_user in", values, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserNotIn(List<String> values) {
            addCriterion("so_update_user not in", values, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserBetween(String value1, String value2) {
            addCriterion("so_update_user between", value1, value2, "soUpdateUser");
            return (Criteria) this;
        }

        public Criteria andSoUpdateUserNotBetween(String value1, String value2) {
            addCriterion("so_update_user not between", value1, value2, "soUpdateUser");
            return (Criteria) this;
        }
    }

    /**
     * sys_operate
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

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