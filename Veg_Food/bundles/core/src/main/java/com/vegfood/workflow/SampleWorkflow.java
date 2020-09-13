package com.vegfood.workflow;

import javax.jcr.Node;
import javax.jcr.RepositoryException;
import javax.jcr.Session;
import javax.jcr.ValueFormatException;
import javax.jcr.lock.LockException;
import javax.jcr.nodetype.ConstraintViolationException;
import javax.jcr.version.VersionException;

import org.apache.sling.api.resource.Resource;
import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.ParticipantStepChooser;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

@Component(service = WorkflowProcess.class, property = { Constants.SERVICE_DESCRIPTION + "=Sample Workflow",
		"process.label=Test Workflow" })
public class SampleWorkflow implements WorkflowProcess, ParticipantStepChooser {

	@SuppressWarnings("unused")
	@Override
	public void execute(WorkItem item, WorkflowSession session, MetaDataMap args) throws WorkflowException {
		WorkflowData workflowData = item.getWorkflowData();
		String payload = workflowData.getPayload().toString();
		ResourceResolver resolver = session.adaptTo(ResourceResolver.class);
		
		// To get JCR Session in Workflow		
		Session ses = session.adaptTo(Session.class);
		Session sess = resolver.adaptTo(Session.class);
		
		PageManager pageManager = resolver.adaptTo(PageManager.class);
		if (null != payload && null != pageManager) {
			Page page = pageManager.getPage(payload);
			Resource contentResource = page.getContentResource();
			Node node = contentResource.adaptTo(Node.class);
			try {
				node.setProperty("analyticsTitle", page.getTitle().concat(" Analytics"));
				node.getSession().save();
			} catch (ValueFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (VersionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (LockException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ConstraintViolationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (RepositoryException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public String getParticipant(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap args)
			throws WorkflowException {
		// TODO Auto-generated method stub
		return null;
	}

}
