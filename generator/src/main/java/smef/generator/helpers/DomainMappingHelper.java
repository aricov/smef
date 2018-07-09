package smef.generator.helpers;

import java.io.IOException;
import java.util.Map;

import com.github.jknack.handlebars.Handlebars;
import com.github.jknack.handlebars.Helper;
import com.github.jknack.handlebars.Options;

public class DomainMappingHelper implements Helper<String> {

	public static final String NAME = "mapDomain";
	
	private final Map<String, String> domainMappings;

	public DomainMappingHelper(Map<String, String> domainMappings) {
		this.domainMappings = domainMappings;
	}

	@Override
	public CharSequence apply(String domain, Options options) throws IOException {
		String mapped = domainMappings.get(domain);
		return mapped != null ? mapped : domain;
	}

	public static Handlebars register(Handlebars handlebars, Map<String, String> mappings) {
		return handlebars.registerHelper(NAME, new DomainMappingHelper(mappings));
	}
	
}
