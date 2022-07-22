ALTER TABLE forma_pagamento ADD COLUMN data_alteracao TIMESTAMP;
ALTER TABLE forma_pagamento ADD COLUMN data_criacao TIMESTAMP NOT NULL DEFAULT NOW();