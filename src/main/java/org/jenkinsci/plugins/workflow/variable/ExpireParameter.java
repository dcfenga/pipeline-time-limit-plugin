package org.jenkinsci.plugins.workflow.variable;

import hudson.Extension;
import hudson.model.AbstractDescribableImpl;
import hudson.model.Descriptor;
import org.kohsuke.stapler.DataBoundConstructor;

import java.util.concurrent.TimeUnit;

/**
 * Encapsulates the parameter of expire.
 *
 * @author dcfenga
 */
public class ExpireParameter extends AbstractDescribableImpl<ExpireParameter> {
	
	private final int time;

	private final TimeUnit unit;

	@DataBoundConstructor
	public ExpireParameter(int time, TimeUnit unit) {
		this.time = time;
		this.unit = unit;
	}

	public int getTime() {
		return time;
	}

	public TimeUnit getUnit() {
		return unit;
	}

	@Extension
	public static class DescriptorImpl extends Descriptor<ExpireParameter> {

		@Override
		public String getDisplayName() {
			return "Time expire paramter";
		}
	}
}
