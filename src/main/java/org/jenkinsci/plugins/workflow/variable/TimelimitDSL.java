package org.jenkinsci.plugins.workflow.variable;

import groovy.lang.Binding;
import hudson.Extension;
import org.jenkinsci.plugins.workflow.cps.CpsScript;
import org.jenkinsci.plugins.workflow.cps.GlobalVariable;

/**
 * The timelimit global varaible. It support the following function:
 * <code>timeExpire</code>
 *
 * @author dcfenga
 */

@Extension
public class TimelimitDSL extends GlobalVariable {

	@Override
	public String getName() {
		return "timelimit";
	}

	@Override
	public Object getValue(CpsScript script) throws Exception {
		Binding binding = script.getBinding();
		Object timelimit;

		if (binding.hasVariable(getName())) {
			timelimit = binding.getVariable(getName());
		} else {
			timelimit = script.getClass().getClassLoader()
					.loadClass("org.jenkinsci.plugins.workflow.variable.Timelimit").getConstructor(CpsScript.class)
					.newInstance(script);
		}

		return timelimit;
	}

}
