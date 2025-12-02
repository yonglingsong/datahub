package com.linkedin.metadata.aspect.patch.template.common;

import com.fasterxml.jackson.databind.JsonNode;
import com.linkedin.common.UrnArray;
import com.linkedin.data.template.RecordTemplate;
import com.linkedin.domain.Domains;
import com.linkedin.metadata.aspect.patch.template.Template;
import javax.annotation.Nonnull;

/**
 * Template for Domains aspect patches.
 * Supports patching the list of domain URNs assigned to an entity.
 */
public class DomainsTemplate implements Template<Domains> {

  @Override
  public Domains getSubtype(RecordTemplate recordTemplate) throws ClassCastException {
    if (recordTemplate instanceof Domains) {
      return (Domains) recordTemplate;
    }
    throw new ClassCastException("Unable to cast RecordTemplate to Domains");
  }

  @Override
  public Class<Domains> getTemplateType() {
    return Domains.class;
  }

  @Nonnull
  @Override
  public Domains getDefault() {
    Domains domains = new Domains();
    domains.setDomains(new UrnArray());
    return domains;
  }

  @Nonnull
  @Override
  public JsonNode transformFields(JsonNode baseNode) {
    // No transformation needed for domains - it's already a simple array
    return baseNode;
  }

  @Nonnull
  @Override
  public JsonNode rebaseFields(JsonNode patched) {
    // No transformation needed for domains - it's already a simple array
    return patched;
  }
}