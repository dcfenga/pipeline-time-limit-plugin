package org.jenkinsci.plugins.workflow.variable

class Timelimit implements Serializable {

    private org.jenkinsci.plugins.workflow.cps.CpsScript script

    public Timelimit(org.jenkinsci.plugins.workflow.cps.CpsScript script) {
        this.script = script
    }

    public <V> V expire(int time, String unit, Closure<V> body) {
        node {
            script.timeExpire([time: time, unit: unit]) {
                body()
            }
        }
    }

    private <V> V node(Closure<V> body) {
        if (script.env.NODE_NAME != null) {
            // Already inside a node block.
            body()
        } else {
            script.node {
                body()
            }
        }
    }
}
