#!/bin/bash

# Some utils about shells

RESULT_ADDRESS=result
ORDERER_RESULT_ADDRESS=$RESULT_ADDRESS/orderer
CHAINCODE_RESULT_ADDRESS=$RESULT_ADDRESS/chaincode
QUERY_OR_INVOKE_RESULT_ADDRESS=$RESULT_ADDRESS/peer
BIN_ADDRESS=/home/ubuntu/ms/fabric-samples/bin  #var
peer=$BIN_ADDRESS/peer
LOG=$RESULT_ADDRESS/test.log

setGlobals() {
    local ORG_NUM=$1
    infoln "Using organization ${ORG_NUM}"
    # set -x
    ADDRESS=/home/ubuntu/ms/fabric-samples/test-network #var
    export PATH=${ADDRESS}/../bin:$PATH
    export FABRIC_CFG_PATH=$ADDRESS/../config/
    export CORE_PEER_TLS_ENABLED=true

    export CORE_PEER_LOCALMSPID="Org"${ORG_NUM}"MSP"
    export CORE_PEER_TLS_ROOTCERT_FILE=${ADDRESS}/organizations/peerOrganizations/org${ORG_NUM}.example.com/peers/peer0.org${ORG_NUM}.example.com/tls/ca.crt
    export CORE_PEER_MSPCONFIGPATH=${ADDRESS}/organizations/peerOrganizations/org${ORG_NUM}.example.com/users/Admin@org${ORG_NUM}.example.com/msp
    if [ $ORG_NUM -eq 1 ]; then
        export CORE_PEER_ADDRESS=localhost:7051
    elif [ $ORG_NUM -eq 2 ]; then
        export CORE_PEER_ADDRESS=localhost:9051
    elif [ $ORG_NUM -eq 3 ]; then
        export CORE_PEER_ADDRESS=localhost:11051
    else
        errorln "ORG Unknown"
    fi
    # set +x
}

function query1() {
    ./test_fabric/example_query.sh 1
}

function query2() {
    ./test_fabric/example_query.sh 2
}

C_RESET='\033[0m'
C_RED='\033[0;31m'
C_GREEN='\033[0;32m'
C_BLUE='\033[0;34m'
C_YELLOW='\033[1;33m'

# println echos string
function println() {
  # echo -e "$1"
  echo -e $@
}

# errorln echos i red color
function errorln() {
  println "${C_RED}$@${C_RESET}"
}

# successln echos in green color
function successln() {
  println "${C_GREEN}$@${C_RESET}"
}

# infoln echos in blue color
function infoln() {
  println "${C_BLUE}$@${C_RESET}"
}

# warnln echos in yellow color
function warnln() {
  println "${C_YELLOW}$@${C_RESET}"
}

# fatalln echos in red color and exits with fail status
function fatalln() {
  errorln $@
  exit 1
}


stop_docker() { 
    for i in "$@"
    do
        println "Stopping ${i}"
        docker stop $i >/dev/null
        wait
        println "Stop Success"
    done
}

start_docker() { 
    for i in "$@"
    do
        println "Starting ${i}"
        docker start $i >/dev/null
        wait
        sleep 60
        # TODO
        println "Start Success"
    done
}

function get_block() {
  setGlobals 1
  $peer channel fetch $1 -c mychannel --orderer orderer0.example.com:7050 --tls --cafile /home/ubuntu/ms/fabric-samples/test-network/organizations/ordererOrganizations/example.com/orderers/orderer0.example.com/msp/tlscacerts/tlsca.example.com-cert.pem
}

if [[ ! -f $RESULT_ADDRESS/test.log ]]; then
  touch $RESULT_ADDRESS/test.log
fi