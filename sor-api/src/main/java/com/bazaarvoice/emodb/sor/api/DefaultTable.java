package com.bazaarvoice.emodb.sor.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

import javax.annotation.Nullable;
import java.util.Map;

import static com.google.common.base.Preconditions.checkNotNull;

public final class DefaultTable implements Table {
    private final String _name;
    private final TableOptions _options;
    private final Map<String, Object> _template;
    private final TableAvailability _availability;

    public DefaultTable(@JsonProperty("name") String name,
                        @JsonProperty("options") TableOptions options,
                        @JsonProperty("template") Map<String, Object> template,
                        @JsonProperty("availability") @Nullable TableAvailability availability) {
        _name = checkNotNull(name, "name");
        _options = checkNotNull(options, "options");
        _template = checkNotNull(template, "template");
        _availability = availability;
    }

    @Override
    public String getName() {
        return _name;
    }

    @Override
    public TableOptions getOptions() {
        return _options;
    }

    @Override
    public Map<String, Object> getTemplate() {
        return _template;
    }

    @Override
    public TableAvailability getAvailability() {
        return _availability;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof DefaultTable)) {
            return false;
        }
        DefaultTable that = (DefaultTable) o;
        return _name.equals(that._name) &&
                _options.equals(that._options) &&
                _template.equals(that._template) &&
                Objects.equal(_availability, _availability);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(_name,  _options, _template, _availability);
    }

    @Override
    public String toString() {
        return _name;
    }
}
