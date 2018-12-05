package pcosee.converter;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.io.FilenameUtils;
import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import pcosee.model.Documento;

@Component
public class DocumentoConverter implements Converter<MultipartFile, Documento> {

    @Override
    public Documento convert(MultipartFile source) {
        try {
            Documento documento = new Documento();
            documento.setNome(source.getOriginalFilename().replaceAll(" ", ""));
            documento.setTipo(source.getContentType());
            documento.setExtensao(FilenameUtils.getExtension(source.getOriginalFilename()));
            documento.setArquivo(Base64.encodeBase64String(source.getBytes()));
            return documento;
        } catch (Exception e) {
            throw new ConversionFailedException(TypeDescriptor.valueOf(CommonsMultipartFile.class), TypeDescriptor.valueOf(Documento.class), source, e.getCause());
        }
    }
}
