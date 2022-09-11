package proxy;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProxyTest {

    @Test
    public void testProxy() {
        InterfaceClass proxy = ProxyHelper.getProxy(new OriginalClass());

        String message = proxy.getMessage("Aaron");

        assertThat(message).isEqualTo("Hello Aaron! You're using proxy!");
    }

    @Test
    public void testProxyUsingApi() {
        InterfaceClass proxy = ProxyHelper.getProxyUsingApi(new OriginalClass());

        String message = proxy.getMessage("Aaron");

        assertThat(message).isEqualTo("Hello Aaron! You're using proxy!");
    }


    @Test
    public void shouldThrowIllegalAccessExceptionWhenOwnerTriesToSetHisOwnRating() {
        final PersonBean personBean = ProxyHelper.getOwnerProxy(new PersonBeanImplementation());

        assertThrows(IllegalAccessException.class, () -> personBean.setHotOrNotRating(5));
    }

    @Test
    public void nonOwnerShouldBeAbleToSetRating() throws Exception {
        final PersonBean personBean = ProxyHelper.getNonOwnerProxy(new PersonBeanImplementation());

        personBean.setHotOrNotRating(4);

        assertThat(personBean.getHotOrNotRating()).isEqualTo(4);
    }

    @Test
    public void shouldThrowIllegalAccessExceptionWhenNonOwnerTriesToSetName() {
        final PersonBean personBean = ProxyHelper.getNonOwnerProxy(new PersonBeanImplementation());

        assertThrows(IllegalAccessException.class, () -> personBean.setName("Nanette"));
    }

    @Test
    public void shouldThrowIllegalAccessExceptionWhenNonOwnerTriesToSetGender() {
        final PersonBean personBean = ProxyHelper.getNonOwnerProxy(new PersonBeanImplementation());

        assertThrows(IllegalAccessException.class, () -> personBean.setGender("Female"));
    }

    @Test
    public void shouldThrowIllegalAccessExceptionWhenNonOwnerTriesToSetInterests() {
        final PersonBean personBean = ProxyHelper.getNonOwnerProxy(new PersonBeanImplementation());

        assertThrows(IllegalAccessException.class, () -> personBean.setInterests("Books, movies"));
    }
}
