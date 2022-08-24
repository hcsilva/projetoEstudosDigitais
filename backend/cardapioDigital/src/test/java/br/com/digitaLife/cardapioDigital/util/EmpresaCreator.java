package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;

import br.com.digitaLife.cardapioDigital.model.Empresa;
import java.io.IOException;

public class EmpresaCreator {
    public static final byte[] IMAGEM = getImageBytes();

    public static EmpresaDto createEmpresaDtoForSave() {
        return EmpresaDto.builder()
                .cnpj("09464292000198")
                .descricao("Empresa Teste Descrição")
                .email("emailTeste@gmail.com")
                .logo(IMAGEM)
                .imagemCapa(IMAGEM)
                .facebook("testeFacebookPage")
                .instagram("testeInstagramPage")
                .razaoSocial("Empresa teste Razão Social")
                .site("www.empresateste.com.br")
                .telefoneContato("54991875569")
                .whatsapp("54991875569")
                .build();
    }

    public static Empresa validEmpresa() {
        return Empresa.builder()
                .id(1L)
                .cnpj("09464292000198")
                .descricao("Empresa Teste Descrição")
                .email("emailTeste@gmail.com")
                .logo(IMAGEM)
                .imagemCapa(IMAGEM)
                .facebook("testeFacebookPage")
                .instagram("testeInstagramPage")
                .razaoSocial("Empresa teste Razão Social")
                .site("www.empresateste.com.br")
                .telefoneContato("54991875569")
                .whatsapp("54991875569")
                .build();
    }

    public static EmpresaDto createEmpresaDtoToUpdate() {
        return EmpresaDto.builder()
                .cnpj("09464292000198")
                .descricao("Empresa Teste Update")
                .email("emailUpdateTeste@gmail.com")
                .facebook("testeFacebookPageUpdate")
                .instagram("testeInstagramPageUpdate")
                .razaoSocial("Empresa Razão Social Update")
                .site("www.empresatesteUpdate.com.br")
                .telefoneContato("99999999999")
                .whatsapp("888888888")
                .build();
    }


    public static Empresa empresaUpdateValid() {
        return Empresa.builder()
                .cnpj("09464292000198")
                .descricao("Empresa Teste Update")
                .email("emailUpdateTeste@gmail.com")
                .facebook("testeFacebookPageUpdate")
                .instagram("testeInstagramPageUpdate")
                .razaoSocial("Empresa Razão Social Update")
                .site("www.empresatesteUpdate.com.br")
                .telefoneContato("99999999999")
                .whatsapp("888888888")
                .build();
    }

    private static byte[] getImageBytes() {
        final String path = "src/test/java/images/test_image.png";
        try {
            return ConvertImageToByteCode.extractBytes(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
