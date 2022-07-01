package br.com.digitaLife.cardapioDigital.util;

import br.com.digitaLife.cardapioDigital.dto.EmpresaDto;

import java.io.IOException;

public class EmpresaCreator {


    public static EmpresaDto createEmpresaForSave() throws IOException {
        EmpresaDto empresaDto = new EmpresaDto();
        empresaDto.setCnpj("09464292000198");
        empresaDto.setDescricao("Empresa Teste Descrição");
        // empresaDto.setEmail("emailTeste@gmail.com");
        empresaDto.setLogo(getImageBytes());
        empresaDto.setImagemCapa(getImageBytes());
        empresaDto.setFacebook("testeFacebookPage");
        empresaDto.setInstagram("testeInstagramPage");
        empresaDto.setRazaoSocial("Empresa teste Razão Social");
        empresaDto.setSite("www.empresateste.com.br");
        empresaDto.setTelefoneContato("54991875569");
        empresaDto.setWhatsapp("54991875569");

        return empresaDto;
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
