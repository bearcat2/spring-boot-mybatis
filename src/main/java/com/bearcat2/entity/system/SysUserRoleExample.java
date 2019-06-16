package com.bearcat2.entity.system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class SysUserRoleExample implements Serializable {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private static final long serialVersionUID = 1L;

    public SysUserRoleExample() {
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
     * <p>Description:  sys_user_role表的实体类 </p>
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

        public Criteria andSurIdIsNull() {
            addCriterion("sur_id is null");
            return (Criteria) this;
        }

        public Criteria andSurIdIsNotNull() {
            addCriterion("sur_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurIdEqualTo(Integer value) {
            addCriterion("sur_id =", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdNotEqualTo(Integer value) {
            addCriterion("sur_id <>", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdGreaterThan(Integer value) {
            addCriterion("sur_id >", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sur_id >=", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdLessThan(Integer value) {
            addCriterion("sur_id <", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdLessThanOrEqualTo(Integer value) {
            addCriterion("sur_id <=", value, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdIn(List<Integer> values) {
            addCriterion("sur_id in", values, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdNotIn(List<Integer> values) {
            addCriterion("sur_id not in", values, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdBetween(Integer value1, Integer value2) {
            addCriterion("sur_id between", value1, value2, "surId");
            return (Criteria) this;
        }

        public Criteria andSurIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sur_id not between", value1, value2, "surId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdIsNull() {
            addCriterion("sur_user_id is null");
            return (Criteria) this;
        }

        public Criteria andSurUserIdIsNotNull() {
            addCriterion("sur_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurUserIdEqualTo(Integer value) {
            addCriterion("sur_user_id =", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdNotEqualTo(Integer value) {
            addCriterion("sur_user_id <>", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdGreaterThan(Integer value) {
            addCriterion("sur_user_id >", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sur_user_id >=", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdLessThan(Integer value) {
            addCriterion("sur_user_id <", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("sur_user_id <=", value, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdIn(List<Integer> values) {
            addCriterion("sur_user_id in", values, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdNotIn(List<Integer> values) {
            addCriterion("sur_user_id not in", values, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdBetween(Integer value1, Integer value2) {
            addCriterion("sur_user_id between", value1, value2, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sur_user_id not between", value1, value2, "surUserId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdIsNull() {
            addCriterion("sur_role_id is null");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdIsNotNull() {
            addCriterion("sur_role_id is not null");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdEqualTo(Integer value) {
            addCriterion("sur_role_id =", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdNotEqualTo(Integer value) {
            addCriterion("sur_role_id <>", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdGreaterThan(Integer value) {
            addCriterion("sur_role_id >", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("sur_role_id >=", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdLessThan(Integer value) {
            addCriterion("sur_role_id <", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("sur_role_id <=", value, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdIn(List<Integer> values) {
            addCriterion("sur_role_id in", values, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdNotIn(List<Integer> values) {
            addCriterion("sur_role_id not in", values, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("sur_role_id between", value1, value2, "surRoleId");
            return (Criteria) this;
        }

        public Criteria andSurRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("sur_role_id not between", value1, value2, "surRoleId");
            return (Criteria) this;
        }
    }

    /**
     * sys_user_role
     */
    public static class Criteria extends GeneratedCriteria implements Serializable {

        protected Criteria() {
            super();
        }
    }

    /**
     * <p>Description:  sys_user_role表的实体类 </p>
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