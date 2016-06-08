#!/bin/bash


cat $1 | ./graphvizer.sh | dot -Tpdf > /tmp/graph.pdf ; evince /tmp/graph.pdf ; rm /tmp/graph.pdf