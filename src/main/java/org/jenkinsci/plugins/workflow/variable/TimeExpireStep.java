package org.jenkinsci.plugins.workflow.variable;

import hudson.Extension;
import org.jenkinsci.plugins.workflow.steps.AbstractStepDescriptorImpl;
import org.jenkinsci.plugins.workflow.steps.AbstractStepImpl;
import org.kohsuke.stapler.DataBoundConstructor;

import javax.annotation.Nonnull;

/**
 * Executes the body with a timeout, which will kill the body.
 *
 * @author dcfenga
 */
public class TimeExpireStep extends AbstractStepImpl {

	@Nonnull
	private final ExpireParameter expire;

	@DataBoundConstructor
	public TimeExpireStep(@Nonnull ExpireParameter expire) {
		assert expire != null;
		this.expire = expire;
	}

	public ExpireParameter getExpire() {
		return expire;
	}

	@Extension
	public static class DescriptorImpl extends AbstractStepDescriptorImpl {

		public DescriptorImpl() {
			super(TimeExpireStepExecution.class);
		}

		@Override
		public String getFunctionName() {
			return "timeExpire";
		}

		@Override
		public String getDisplayName() {
			return "Sets up time expired";
		}

		@Override
		public boolean takesImplicitBlockArgument() {
			return true;
		}

		@Override
		public boolean isAdvanced() {
			return true;
		}
	}

}
