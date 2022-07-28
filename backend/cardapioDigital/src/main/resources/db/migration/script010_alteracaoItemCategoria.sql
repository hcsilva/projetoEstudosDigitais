ALTER TABLE item_categoria ADD COLUMN data_alteracao TIMESTAMP;
ALTER TABLE item_categoria ADD COLUMN data_criacao TIMESTAMP NOT NULL DEFAULT NOW();