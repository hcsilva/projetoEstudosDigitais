ALTER TABLE horario_funcionamento ADD COLUMN data_alteracao TIMESTAMP NOT NULL DEFAULT NOW();
ALTER TABLE horario_funcionamento ADD COLUMN data_criacao TIMESTAMP NOT NULL DEFAULT NOW();