#! /bin/bash

# Summary result

. utils.sh

function summary() {
    record_separator

    print_align 一级指标 二级指标 三级指标 是否满足
    print_align 数据安全 可靠性 账本可靠性 是
    print_align 数据安全 可靠性 区块链网络可靠性 是
    print_align 数据安全 可靠性 CPU/磁盘/内存/网络 是
    print_align 算法安全 密码算法 加密算法验证 是
    print_align 算法安全 共识算法 一致性验证 是
    print_align 算法安全 共识算法 共识算法验证 是
    print_align 算法安全 智能合约 幂等性和持久性 是
    print_align 算法安全 智能合约 语言类风险 是
    print_align 算法安全 智能合约 外部访问风险 是
    print_align 算法安全 智能合约 隐私数据安全 否
    print_align 算法安全 智能合约 逻辑安全 是
    print_align 算法安全 智能合约 其他逻辑风险 是
    print_align 其他 扩展 支持微服务架构 是
    print_align 其他 扩展 支持可信时间戳 否
    print_align 其他 扩展 支持跨链 否

    record_separator
    
    # cat $result
}

function record_separator() {
    println "-------------------------------------------------"
}

function print_align() {
    printf "%-10s\t%-20s\t%-32s\t%-10s\n" $1 $2 $3 $4
}

summary

