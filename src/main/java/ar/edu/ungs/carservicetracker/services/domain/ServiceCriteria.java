package ar.edu.ungs.carservicetracker.services.domain;

import ar.edu.ungs.carservicetracker.shared.domain.Criteria;

import java.util.Objects;

public final class ServiceCriteria extends Criteria {
    private final String userId;

    public ServiceCriteria(Integer size,
                           Integer page,
                           String userId) {
        super(size, page);
        this.userId = userId;
    }

    public String userId() {
        return userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        ServiceCriteria that = (ServiceCriteria) o;
        return Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), userId);
    }

    @Override
    public String toString() {
        return "ServiceCriteria{" +
                "userId=" + userId +
                '}';
    }
}
