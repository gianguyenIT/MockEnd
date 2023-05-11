package fa.training.mapper;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import java.lang.reflect.Type;

public abstract class AbstractMapper<T, U> {

    protected final ModelMapper mapper;
    private Class<?> tClazz;
    private Class<?> uClazz;


    public AbstractMapper() {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setPreferNestedProperties(false);
    }

    public AbstractMapper(Class<?> tClazz, Class<?> uClazz) {
        mapper = new ModelMapper();
        mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT)
                .setDeepCopyEnabled(false)
                .setPreferNestedProperties(false)
                .setSkipNullEnabled(true);
        this.tClazz = tClazz;
        this.uClazz = uClazz;
    }

    public T convertDTOToEntity(U u) {
        return convertDTOToEntity(u, tClazz);
    }

    /**
     * Convert DTO to entity
     * @param u
     * @param tClazz
     * @return
     */
    private T convertDTOToEntity(U u, Class<?> tClazz) {
        if (null == u) return null;
        return mapper.map(u, (Type) tClazz);
    };

    /**
     * Convert entity to DTO
     * @param t
     * @return
     */
    public U convertEntityToDTO(T t) {
        return convertEntityToDTO(t, uClazz);
    }

    /**
     * Convert entity to DTO
     * @param t
     * @param uClazz
     * @return
     */
    private U convertEntityToDTO(T t, Class<?> uClazz) {
        if (null == t) return null;
        return mapper.map(t, (Type) uClazz);
    }

    /**
     * Update dto against entity.
     * @param u dto
     * @param oldEntity entity
     * @return updated entity
     */
    public T mapDTOToEntity(U u, T oldEntity) {
        if (null == u) return null;
        mapper.map(u, oldEntity);
        return oldEntity;
    };
    //end
}
