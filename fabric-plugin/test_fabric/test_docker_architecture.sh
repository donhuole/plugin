#!/bin/bash

# query if using docker architecture

. test_fabric/utils.sh

function test_if_use_docker_architecture() {
    local cmd=`sudo docker ps | awk '{print $3}' | grep orderer`
    # println $cmd
    if [[ $cmd ]]; then
        successln "Using Docker Architecture!"
    else
        warnln "Not Using Docker Architecture!"
    fi
}

test_if_use_docker_architecture