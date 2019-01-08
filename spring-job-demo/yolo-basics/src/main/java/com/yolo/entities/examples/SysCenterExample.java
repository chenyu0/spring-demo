package com.yolo.entities.examples;

import java.util.ArrayList;
import java.util.List;

public class SysCenterExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysCenterExample() {
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

    protected abstract static class GeneratedCriteria {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("id like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("id not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCenterCodeIsNull() {
            addCriterion("center_code is null");
            return (Criteria) this;
        }

        public Criteria andCenterCodeIsNotNull() {
            addCriterion("center_code is not null");
            return (Criteria) this;
        }

        public Criteria andCenterCodeEqualTo(String value) {
            addCriterion("center_code =", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotEqualTo(String value) {
            addCriterion("center_code <>", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeGreaterThan(String value) {
            addCriterion("center_code >", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeGreaterThanOrEqualTo(String value) {
            addCriterion("center_code >=", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLessThan(String value) {
            addCriterion("center_code <", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLessThanOrEqualTo(String value) {
            addCriterion("center_code <=", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeLike(String value) {
            addCriterion("center_code like", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotLike(String value) {
            addCriterion("center_code not like", value, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeIn(List<String> values) {
            addCriterion("center_code in", values, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotIn(List<String> values) {
            addCriterion("center_code not in", values, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeBetween(String value1, String value2) {
            addCriterion("center_code between", value1, value2, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterCodeNotBetween(String value1, String value2) {
            addCriterion("center_code not between", value1, value2, "centerCode");
            return (Criteria) this;
        }

        public Criteria andCenterNameIsNull() {
            addCriterion("center_name is null");
            return (Criteria) this;
        }

        public Criteria andCenterNameIsNotNull() {
            addCriterion("center_name is not null");
            return (Criteria) this;
        }

        public Criteria andCenterNameEqualTo(String value) {
            addCriterion("center_name =", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameNotEqualTo(String value) {
            addCriterion("center_name <>", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameGreaterThan(String value) {
            addCriterion("center_name >", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameGreaterThanOrEqualTo(String value) {
            addCriterion("center_name >=", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameLessThan(String value) {
            addCriterion("center_name <", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameLessThanOrEqualTo(String value) {
            addCriterion("center_name <=", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameLike(String value) {
            addCriterion("center_name like", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameNotLike(String value) {
            addCriterion("center_name not like", value, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameIn(List<String> values) {
            addCriterion("center_name in", values, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameNotIn(List<String> values) {
            addCriterion("center_name not in", values, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameBetween(String value1, String value2) {
            addCriterion("center_name between", value1, value2, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterNameNotBetween(String value1, String value2) {
            addCriterion("center_name not between", value1, value2, "centerName");
            return (Criteria) this;
        }

        public Criteria andCenterTypeIsNull() {
            addCriterion("center_type is null");
            return (Criteria) this;
        }

        public Criteria andCenterTypeIsNotNull() {
            addCriterion("center_type is not null");
            return (Criteria) this;
        }

        public Criteria andCenterTypeEqualTo(String value) {
            addCriterion("center_type =", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeNotEqualTo(String value) {
            addCriterion("center_type <>", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeGreaterThan(String value) {
            addCriterion("center_type >", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeGreaterThanOrEqualTo(String value) {
            addCriterion("center_type >=", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeLessThan(String value) {
            addCriterion("center_type <", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeLessThanOrEqualTo(String value) {
            addCriterion("center_type <=", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeLike(String value) {
            addCriterion("center_type like", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeNotLike(String value) {
            addCriterion("center_type not like", value, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeIn(List<String> values) {
            addCriterion("center_type in", values, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeNotIn(List<String> values) {
            addCriterion("center_type not in", values, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeBetween(String value1, String value2) {
            addCriterion("center_type between", value1, value2, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterTypeNotBetween(String value1, String value2) {
            addCriterion("center_type not between", value1, value2, "centerType");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceIsNull() {
            addCriterion("center_datasource is null");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceIsNotNull() {
            addCriterion("center_datasource is not null");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceEqualTo(String value) {
            addCriterion("center_datasource =", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceNotEqualTo(String value) {
            addCriterion("center_datasource <>", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceGreaterThan(String value) {
            addCriterion("center_datasource >", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceGreaterThanOrEqualTo(String value) {
            addCriterion("center_datasource >=", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceLessThan(String value) {
            addCriterion("center_datasource <", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceLessThanOrEqualTo(String value) {
            addCriterion("center_datasource <=", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceLike(String value) {
            addCriterion("center_datasource like", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceNotLike(String value) {
            addCriterion("center_datasource not like", value, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceIn(List<String> values) {
            addCriterion("center_datasource in", values, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceNotIn(List<String> values) {
            addCriterion("center_datasource not in", values, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceBetween(String value1, String value2) {
            addCriterion("center_datasource between", value1, value2, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterDatasourceNotBetween(String value1, String value2) {
            addCriterion("center_datasource not between", value1, value2, "centerDatasource");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeIsNull() {
            addCriterion("center_parent_code is null");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeIsNotNull() {
            addCriterion("center_parent_code is not null");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeEqualTo(String value) {
            addCriterion("center_parent_code =", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeNotEqualTo(String value) {
            addCriterion("center_parent_code <>", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeGreaterThan(String value) {
            addCriterion("center_parent_code >", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeGreaterThanOrEqualTo(String value) {
            addCriterion("center_parent_code >=", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeLessThan(String value) {
            addCriterion("center_parent_code <", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeLessThanOrEqualTo(String value) {
            addCriterion("center_parent_code <=", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeLike(String value) {
            addCriterion("center_parent_code like", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeNotLike(String value) {
            addCriterion("center_parent_code not like", value, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeIn(List<String> values) {
            addCriterion("center_parent_code in", values, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeNotIn(List<String> values) {
            addCriterion("center_parent_code not in", values, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeBetween(String value1, String value2) {
            addCriterion("center_parent_code between", value1, value2, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andCenterParentCodeNotBetween(String value1, String value2) {
            addCriterion("center_parent_code not between", value1, value2, "centerParentCode");
            return (Criteria) this;
        }

        public Criteria andEnableCacheIsNull() {
            addCriterion("enable_cache is null");
            return (Criteria) this;
        }

        public Criteria andEnableCacheIsNotNull() {
            addCriterion("enable_cache is not null");
            return (Criteria) this;
        }

        public Criteria andEnableCacheEqualTo(String value) {
            addCriterion("enable_cache =", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheNotEqualTo(String value) {
            addCriterion("enable_cache <>", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheGreaterThan(String value) {
            addCriterion("enable_cache >", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheGreaterThanOrEqualTo(String value) {
            addCriterion("enable_cache >=", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheLessThan(String value) {
            addCriterion("enable_cache <", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheLessThanOrEqualTo(String value) {
            addCriterion("enable_cache <=", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheLike(String value) {
            addCriterion("enable_cache like", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheNotLike(String value) {
            addCriterion("enable_cache not like", value, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheIn(List<String> values) {
            addCriterion("enable_cache in", values, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheNotIn(List<String> values) {
            addCriterion("enable_cache not in", values, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheBetween(String value1, String value2) {
            addCriterion("enable_cache between", value1, value2, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnableCacheNotBetween(String value1, String value2) {
            addCriterion("enable_cache not between", value1, value2, "enableCache");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantIsNull() {
            addCriterion("enble_constant is null");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantIsNotNull() {
            addCriterion("enble_constant is not null");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantEqualTo(String value) {
            addCriterion("enble_constant =", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantNotEqualTo(String value) {
            addCriterion("enble_constant <>", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantGreaterThan(String value) {
            addCriterion("enble_constant >", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantGreaterThanOrEqualTo(String value) {
            addCriterion("enble_constant >=", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantLessThan(String value) {
            addCriterion("enble_constant <", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantLessThanOrEqualTo(String value) {
            addCriterion("enble_constant <=", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantLike(String value) {
            addCriterion("enble_constant like", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantNotLike(String value) {
            addCriterion("enble_constant not like", value, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantIn(List<String> values) {
            addCriterion("enble_constant in", values, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantNotIn(List<String> values) {
            addCriterion("enble_constant not in", values, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantBetween(String value1, String value2) {
            addCriterion("enble_constant between", value1, value2, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andEnbleConstantNotBetween(String value1, String value2) {
            addCriterion("enble_constant not between", value1, value2, "enbleConstant");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNull() {
            addCriterion("data_type is null");
            return (Criteria) this;
        }

        public Criteria andDataTypeIsNotNull() {
            addCriterion("data_type is not null");
            return (Criteria) this;
        }

        public Criteria andDataTypeEqualTo(String value) {
            addCriterion("data_type =", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotEqualTo(String value) {
            addCriterion("data_type <>", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThan(String value) {
            addCriterion("data_type >", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeGreaterThanOrEqualTo(String value) {
            addCriterion("data_type >=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThan(String value) {
            addCriterion("data_type <", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLessThanOrEqualTo(String value) {
            addCriterion("data_type <=", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeLike(String value) {
            addCriterion("data_type like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotLike(String value) {
            addCriterion("data_type not like", value, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeIn(List<String> values) {
            addCriterion("data_type in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotIn(List<String> values) {
            addCriterion("data_type not in", values, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeBetween(String value1, String value2) {
            addCriterion("data_type between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andDataTypeNotBetween(String value1, String value2) {
            addCriterion("data_type not between", value1, value2, "dataType");
            return (Criteria) this;
        }

        public Criteria andParamIsNull() {
            addCriterion("param is null");
            return (Criteria) this;
        }

        public Criteria andParamIsNotNull() {
            addCriterion("param is not null");
            return (Criteria) this;
        }

        public Criteria andParamEqualTo(String value) {
            addCriterion("param =", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotEqualTo(String value) {
            addCriterion("param <>", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThan(String value) {
            addCriterion("param >", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamGreaterThanOrEqualTo(String value) {
            addCriterion("param >=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThan(String value) {
            addCriterion("param <", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLessThanOrEqualTo(String value) {
            addCriterion("param <=", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamLike(String value) {
            addCriterion("param like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotLike(String value) {
            addCriterion("param not like", value, "param");
            return (Criteria) this;
        }

        public Criteria andParamIn(List<String> values) {
            addCriterion("param in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotIn(List<String> values) {
            addCriterion("param not in", values, "param");
            return (Criteria) this;
        }

        public Criteria andParamBetween(String value1, String value2) {
            addCriterion("param between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andParamNotBetween(String value1, String value2) {
            addCriterion("param not between", value1, value2, "param");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNull() {
            addCriterion("request_param is null");
            return (Criteria) this;
        }

        public Criteria andRequestParamIsNotNull() {
            addCriterion("request_param is not null");
            return (Criteria) this;
        }

        public Criteria andRequestParamEqualTo(String value) {
            addCriterion("request_param =", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotEqualTo(String value) {
            addCriterion("request_param <>", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThan(String value) {
            addCriterion("request_param >", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamGreaterThanOrEqualTo(String value) {
            addCriterion("request_param >=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThan(String value) {
            addCriterion("request_param <", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLessThanOrEqualTo(String value) {
            addCriterion("request_param <=", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamLike(String value) {
            addCriterion("request_param like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotLike(String value) {
            addCriterion("request_param not like", value, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamIn(List<String> values) {
            addCriterion("request_param in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotIn(List<String> values) {
            addCriterion("request_param not in", values, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamBetween(String value1, String value2) {
            addCriterion("request_param between", value1, value2, "requestParam");
            return (Criteria) this;
        }

        public Criteria andRequestParamNotBetween(String value1, String value2) {
            addCriterion("request_param not between", value1, value2, "requestParam");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
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