#!/bin/bash
docker run -d --rm --net=host -v $(pwd)/prometheus.yml:/etc/prometheus/prometheus.yml prom/prometheus
