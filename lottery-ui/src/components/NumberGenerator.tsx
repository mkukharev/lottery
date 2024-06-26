import React from 'react';

interface NumberGeneratorProps {
    onGenerate: () => void;
}

const NumberGenerator: React.FC<NumberGeneratorProps> = ({ onGenerate }) => {
    return (
      <button onClick={onGenerate}>Generate Random Number</button>
    );
};

export default NumberGenerator;