package at.ratbox.groceries_list.exceptions;

public class ResourceNotFoundException extends RuntimeException {
	private String resourceType;
	private String resourceName;
	private Object resourceValue;

	public ResourceNotFoundException(String resourceType, String resourceName, Object resourceValue) {
		super(String.format("%s resource not found %s : %s", resourceType, resourceName, resourceValue));
		this.resourceType = resourceType;
		this.resourceName = resourceName;
		this.resourceValue = resourceValue;
	}
}
